package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javafx.scene.image.Image;

public class VolleyBallEvent {
	
	private Participant root;
	private Participant first;
	
	public VolleyBallEvent() {
		
	}
	
	//SPECTATORS METHODS
	
	public void addParticipantIntoTree(Participant part) {
		addParticipantIntoTree(part, root);
	}
	
	public void addParticipantIntoTree(Participant part, Participant current) {
		if(root == null) {
			root = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addParticipantIntoTree(part, current.getLeft());
				}
			} else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addParticipantIntoTree(part, current.getRigth());
				}
			}
			
		}
	}
	
	public String LoadFileAndAddToTree(File path) throws IOException {
		
		FileReader fileReader = new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		int times = 0;
		while(line != null){
			String[] temporalDataArray = line.split(",");
			
			URL url = new URL(temporalDataArray[6]);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			Participant temporalNewParticipant = new Participant(Integer.parseInt(temporalDataArray[0]),temporalDataArray[1],temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],temporalDataArray[5],img,temporalDataArray[7]);
			addParticipantIntoTree(temporalNewParticipant);
			line = br.readLine();
			times ++;
		}
		fileReader.close();
		br.close();
		choiceAleatoryParticipants(times);
		return path.getAbsolutePath();
	}
	
	public Participant searchSpectator(int id) {
		Participant s= new Participant(id,"","","","","",null,"");
		return searchSpectator(root,s);
	}
	
	private Participant searchSpectator(Participant current, Participant s) {
		if(current!=null) {
			if(s.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchSpectator(current.getLeft(),s);
				}else {
					return searchSpectator(current.getRigth(), s);
				}
			}else if(s.compareTo(current)>0){
				if(current.getRigth()!=null) {
					return searchSpectator(current.getRigth(), s);
				}else {
					return searchSpectator(current.getLeft(), s);
				}
			}else {
				return current;
			}
		}
		return current;
	}
	
	
	//PARTICIPANT METHODS
	
	public Participant searchParticipant(int id) {
		Participant current = first;
		Participant found = null;
		boolean find = false;
		
		while(current!= null && find == false) {
			if(current.getId() == id) {
				found = current;
				find = true;
			}else {
				current = current.getNext();
			}
		}
		
		return found;
	}
	
	
	public void choiceAleatoryParticipants(int size) {
		int[] ale = new int[10];
		for(int i=0;i<10;i++) {
			int n=(int) (Math.random() * size) + 1;
			if(i>0) {
				if(notChoice(n,ale)) {
					Participant s=searchParticipant(n);
					addingOficialParticipants(s);
					System.out.println(n+" si lista "+i);
					ale[i]=n;
				}
			}else {
				ale[i]=n;
			}

		}
	}
	
	
	public boolean notChoice(int n, int[]a) {
		boolean flag=true;
		for(int i=0;i<a.length;i++) {
			if(n==a[i]) {
				flag=false;
			}
		}
		return flag;
	}
	
	
	public void addingOficialParticipants(Participant newOne){
		if(first == null){
			first = newOne;
		}else{
			Participant current = first;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(newOne);
			Participant temp = current;
			current = current.getNext();
			current.setPrev(temp);
		}
	}
	
	
	public Participant searchOficialParticipant(int n) {
		Participant current = first;
		Participant returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getId()==n) {
				stop = true;
				returned = current;
			}else {
					current = current.getNext();
			}
		}
		
		return returned;
	}
	
	public Participant getRoot() {
		return root;
	}
	
	public void setRoot(Participant root) {
		this.root = root;
	}
	
	public Participant getFirst() {
		return first;
	}
	
	public void setFirst(Participant first) {
		this.first = first;
	}
}
