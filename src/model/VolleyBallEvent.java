package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class VolleyBallEvent {
	
	private Participant root;
	private Participant first;
	
	public static final String PATH = "data/data.csv";
	
	public VolleyBallEvent() {
		
	}
	
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
	
	public String LoadFileAndAddToTree() throws IOException {
		File file = new File(PATH);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] temporalDataArray = line.split(",");
			
			URL url = new URL(temporalDataArray[6]);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			Participant temporalNewParticipant = new Participant(Integer.parseInt(temporalDataArray[0]),temporalDataArray[1],temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],temporalDataArray[5],img,temporalDataArray[7]);
			addParticipantIntoTree(temporalNewParticipant);
			line = br.readLine();
		}
		fileReader.close();
		br.close();
		
		return PATH;
	}
	
	public List<Participant> preOrder(){
		return preOrder(root);
	}
	private List<Participant> preOrder(Participant currentNode){
		List<Participant> l = new ArrayList<Participant>();
		if(currentNode != null){
			l.add(currentNode);
			List<Participant> ll = preOrder(currentNode.getLeft());
			List<Participant> lr = preOrder(currentNode.getRigth());
			//System.out.println(ll);
			//System.out.println(lr);
			l.addAll(ll);
			l.addAll(lr);
		}
		return l;
	}
	
	/*public List<Participant> amplitud(){
		System.out.println("amplitud1");
		return amplitud(root);
	}
	
	public List<Participant> amplitud(Participant a) {
		System.out.println("Amplitud2");
		List<Participant> cola= new ArrayList<Participant>(); 
		List<Participant> colaAux= new ArrayList<Participant>();
		Participant aux;

		if (a != null) {
			System.out.println("if");
			cola.add(a); 
			while (cola != null) {
				colaAux.add(aux=cola.get(0));
				if (aux.getLeft() != null) {
					cola.add(aux.getLeft()); 
				}
				if (aux.getRigth() != null){
					cola.add(aux.getRigth()); 
				}
				System.out.println("While");
			} 
		}
		return colaAux;
	}*/
	
	public Participant searchParticipant(int id) {
		Participant s= new Participant(id,"","","","","",null,"");
		return searchParticipant(root,s);
	}
	
	private Participant searchParticipant(Participant current, Participant s) {
		if(current!=null) {
			if(s.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchParticipant(current.getLeft(),s);
				}else {
					return searchParticipant(current.getRigth(), s);
				}
			}else if(s.compareTo(current)>0){
				if(current.getRigth()!=null) {
					return searchParticipant(current.getRigth(), s);
				}else {
					return searchParticipant(current.getLeft(), s);
				}
			}else {
				return current;
			}
		}
		return current;
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
