# GeRuDok
This project is an IDE-like desktop application for graphics and text document handling written in Java Swing with a heavy focus on various design patterns.

## Overview
The application supports common IDE functionalities such as creating/switching workspaces, rendering the project tree, importing/exporting projects, sharing documents between projects etc. The projects themselves contain text/graphics documents that the user can edit using the text/graphics editor.

![Alt text](images/GraphicEditor.png?raw=true "")

## Functionalities
* Create/load workspace
* Switch workspace
* Create/delete project
* Import/export project
* Create/delete document in a project
* Import/export document to/from a project
* Share document with another project (every change made to the document is applied in all projects that the document is shared with)
* Create/delete page in a document
* Create/delete slot in a page
* Create/delete text/graphics element in a slot that the user can write/draw to
* Drawing to a graphics element with the graphics editor
  * Draw/erase square or circle
  * Multiple select
  * Cut/copy/paste
  * Undo/redo
* Writing text in a text element using the text editor
  * Bold/italic/underline
  * Font type size and color
  * Subscript/superscript
  
## Implementation details
#### Design patterns used:
* Singleton
* Observer/observable (MVC)
* Command pattern
* State pattern

Java's serialization is used for storing projects.<br><br>
When sharing a document between projects, the document view (implements interface Cloneable) is cloned but points to the same model, so any changes to the model are being rendered simultaneously in all projects.

## Sidenote
This project was an assignment as part of the course - Software design in the 2nd year at the Faculty of Computer Science in Belgrade.

## Download
You can download the .jar file [here](executable/GeRuDok.jar).

## Contributors
- Stefan Ginic <stefangwars@gmail.com>
