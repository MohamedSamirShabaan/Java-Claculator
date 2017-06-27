package eg.edu.alexu.csd.oop.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MyClaculator implements Calculator{
	
	private String temp = "";
	private int index = 0;
	LinkedList <String> l = new LinkedList<String>(); 
	
	private static MyClaculator instance;
	
	public static MyClaculator getInstance() {
		if (instance == null){
			instance = new MyClaculator();
		}
		return instance;
	}
	public static void destoryInstance(){
        instance = null;
	}
	
	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		temp = s;
		int len = l.size();
		int delete = index+1;
		for (int i = index+1 ; i < len ; i++){
			l.remove(delete);
		}
		if (l.size() != 5){
			l.add(temp);
		}
		else {
			l.removeFirst();
			l.add(temp);
		}
		index = l.size()-1;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		int len = l.size() , delete = index + 1;
		for (int i = index+1 ; i < len ; i++){
			l.remove(delete);
		}
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    Object s;
	    try{
	    	temp = l.get(index);
	    	s = engine.eval(temp);
	    	if (s.toString() == "Infinity"){
	    		throw new RuntimeException();
	    	}
	    }catch(Exception e){
	    	throw new RuntimeException();	
	    }
	    return s.toString();
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		if (l.size() == 0)return null;
		return l.get(index);
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		if (index == 0){return null;}
		else {
			index--;
			return l.get(index);
		}
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		if (index == l.size() - 1 || l.size() == 0){return null;}
		else {
			index++;
			return l.get(index);
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
		 BufferedWriter bw = null;
		 
		 try {
			 File file = new File("save.txt");
			 
			  if (!file.exists()) {
			     file.createNewFile();
			  }
			 // if(l.size() == 0)return;

			  FileWriter fw = new FileWriter(file);
			  bw = new BufferedWriter(fw);
			  
			  for (int i = 0 ; i <= index && l.size() != 0; i++){
				  bw.write(l.get(i));
				  if(i != index){bw.newLine();}
			  }

		      } catch (IOException ioe) {
			   ioe.printStackTrace();
			   throw new RuntimeException();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
				   throw new RuntimeException();
			    }
			}
		   }

	@Override
	public void load() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader("save.txt"));
			l.clear();

			while ((sCurrentLine = br.readLine()) != null) {
				l.add(sCurrentLine);
			}
			index = l.size()-1;
			if (index < 0)index = 0;

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				if (br != null)br.close();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

	}
}
			

	
