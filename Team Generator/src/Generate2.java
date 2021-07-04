import java.util.*;
import java.io.*;

public class Generate2{

	ArrayList<String> team1 = new ArrayList<String>();
	ArrayList<String> team2 = new ArrayList<String>();
	BufferedReader br;
	
	public static void main(String[] args){
		new Generate2().go();
	}
	
	public void go(){
		readFile();
		team1 = shuffleTeam(team1);
		team2 = shuffleTeam(team2);
		printTeam(team1, "Equipo 1");
		printTeam(team2, "Equipo 2");
	}
	
	public void readFile(){
		try{
			br = new BufferedReader(new FileReader("players.txt"));
			String line = null;
			String[] linea;
			int r;
			while ((line = br.readLine()) != null){
				linea = line.split(",");
				r = (int) ((Math.random()) * 2);
				team1.add(linea[r]);
				team2.add(linea[1 - r]);
				
			}
		}catch(Exception ex){
			System.out.println("Error Reading File");
		}
		
	}
	
	public ArrayList<String> shuffleTeam(ArrayList<String> team){
		ArrayList<String> temp = new ArrayList<String>();
		int r;
		
		for(int i = 6; i > 1; i--){
			r = random(i);
			temp.add(team.get(r));
			team.remove(r);
		}
		temp.add(team.get(0));
		
		return temp;
		
	}
	
	public void printTeam(ArrayList<String> team, String nombre){
		System.out.println(nombre);
		for(int i = 0; i < 6; i++){
			System.out.println("> " + team.get(i));
			try{
				Thread.sleep(50);
			}catch(Exception ex){
				
			}
			
		}
		System.out.println();
	}
	
	public int random(int range){
		int r = (int) (Math.random() * range);
		return r;
	}
	
}
