package commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import MVC.View;
import Workspace.Element;

import java.util.ArrayList;

/**
 * 
 * 
 * Sadrzi Stack u koji se dodaju nove izvrsene akcije(komande). U zavisnosti od toga da li se klikne na undo ili redo, 
 * brisu se, to jest dodaju u Stack i pozivaju se njihove odgovarajuce undo, odnosno do metoda. Takodje se regulisu toolbar icon
 * za undo i redo, da li su enable-ovane ili disable-ovane.
 * 
 * 
 *  @see Workspace.MainElement
 *  @see commands.AbstractCommand
 *  
 *  
 * 
 * @author Anagnosti
 *
 */
public class CommandManager implements Serializable{

	private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
	private int currentCommand = 0;
	
	public CommandManager(){
		View.get().getActionManager().getRedo().setEnabled(false);
		View.get().getActionManager().getUndo().setEnabled(false);
	}

	public void addCommand(AbstractCommand command){
		while(currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	public void doCommand(){
		if(currentCommand < commands.size()){
			commands.get(currentCommand++).doCommand();
		View.get().getActionManager().getUndo().setEnabled(true);
		}
		if(currentCommand==commands.size()){
			View.get().getActionManager().getRedo().setEnabled(false);
		}
	}

	public void undoCommand(){
		if(currentCommand > 0){
			View.get().getActionManager().getRedo().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		if(currentCommand==0){
			View.get().getActionManager().getUndo().setEnabled(false);
		}
	}

	public void setIcons(){
		if (currentCommand<commands.size()) 
			View.get().getActionManager().getRedo().setEnabled(true);
		else 
			View.get().getActionManager().getRedo().setEnabled(false);
		if (currentCommand!=0)
			View.get().getActionManager().getUndo().setEnabled(true);
		else
			View.get().getActionManager().getUndo().setEnabled(false);
	}
	
}
