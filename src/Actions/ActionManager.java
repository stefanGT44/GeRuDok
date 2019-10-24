package Actions;

/**
 * 
 * Klasa koja sadrzi i inicijalizuje sve akcije. Sluzi kao skladiste akcija.
 * 
 * @see MVC.View
 * 
 * @author Anagnosti
 *
 */
public class ActionManager {

	private AboutAction aboutAction;
	private ExitAction exitAction;
	private NewObjectAction newObjectAction;
	private ExportDocAction exportDocAction;
	private ImportAction importAction;
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	private NewSlotAction newSlotAction;
	private NewElementAction newElementAction;
	private HoverAction hoverAction;
	private BoldAction boldAction;
	private ItalicAction italicAction;
	private SubAction subAction;
	private SuperAction supAction;
	private UnderlineAction underlineAction;
	private Undo undo;
	private Redo redo;
	private Copy copy;
	private Paste paste;
	private Select select;
	private mouseAdapterRP mouseAdapterRP;
	private MouseMotionAdapterRP mouseMotionAdapterRP;
	private MAdapter mAdapter;
	private BrowseAction browseAction;
	private DeleteAction deleteAction;
	private Cut cutAction;
	private SaveAs saveAs;
	private Save save;
	private SwitchWorkspace switchWorkspace;
	private ImportDocAction importDocAction;

	private RectangleAction rectangleAction;
	private CircleAction circleAction;
	private ShareAction shareAction;
	private DeleteShapeAction deleteShapeAction;

	public ActionManager() {
		initializeActions();
	}

	public void initializeActions() {
		hoverAction = new HoverAction();
		aboutAction = new AboutAction();
		exitAction = new ExitAction();
		newObjectAction = new NewObjectAction();
		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newPageAction = new NewPageAction();
		newSlotAction = new NewSlotAction();
		newElementAction = new NewElementAction();
		shareAction = new ShareAction();
		exportDocAction = new ExportDocAction();
		importAction = new ImportAction();
		boldAction = new BoldAction();
		italicAction = new ItalicAction();
		subAction = new SubAction();
		supAction = new SuperAction();
		underlineAction = new UnderlineAction();

		rectangleAction = new RectangleAction();
		circleAction = new CircleAction();
		deleteShapeAction = new DeleteShapeAction();
		undo = new Undo();
		redo = new Redo();
		copy = new Copy();
		paste = new Paste();
		select = new Select();
		cutAction = new Cut();
		saveAs = new SaveAs();
		save = new Save();
		
		switchWorkspace = new SwitchWorkspace();
		importDocAction = new ImportDocAction();
		
		
		mouseAdapterRP = new mouseAdapterRP();
		mouseMotionAdapterRP = new MouseMotionAdapterRP();
		mAdapter = new MAdapter();
		
		browseAction = new BrowseAction();
		deleteAction = new DeleteAction();
	}

	public ShareAction getShareAction() {
		return shareAction;
	}

	public void setShareAction(ShareAction shareAction) {
		this.shareAction = shareAction;
	}

	public ExitAction getExitAction() {
		return exitAction;
	}

	public void setExitAction(ExitAction exitAction) {
		this.exitAction = exitAction;
	}

	public NewObjectAction getNewObjectAction() {
		return newObjectAction;
	}

	public void setNewObjectAction(NewObjectAction newObjectAction) {
		this.newObjectAction = newObjectAction;
	}

	public RectangleAction getRectangleAction() {
		return rectangleAction;
	}

	public void setRectangleAction(RectangleAction rectangleAction) {
		this.rectangleAction = rectangleAction;
	}

	public CircleAction getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(CircleAction circleAction) {
		this.circleAction = circleAction;
	}

	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public ExportDocAction getExportDocAction() {
		return exportDocAction;
	}

	public ImportAction getImportAction() {
		return importAction;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}

	public NewPageAction getNewPageAction() {
		return newPageAction;
	}

	public NewSlotAction getNewSlotAction() {
		return newSlotAction;
	}

	public NewElementAction getNewElementAction() {
		return newElementAction;
	}

	public HoverAction getHoverAction() {
		return hoverAction;
	}

	public DeleteShapeAction getDeleteShapeAction() {
		return deleteShapeAction;
	}

	public BoldAction getBoldAction() {
		return boldAction;
	}

	public ItalicAction getItalicAction() {
		return italicAction;
	}

	public SubAction getSubAction() {
		return subAction;
	}

	public SuperAction getSupAction() {
		return supAction;
	}

	public UnderlineAction getUnderlineAction() {
		return underlineAction;
	}

	public Undo getUndo() {
		return undo;
	}

	public Redo getRedo() {
		return redo;
	}

	public Copy getCopy() {
		return copy;
	}

	public Paste getPaste() {
		return paste;
	}

	public Select getSelect() {
		return select;
	}

	public mouseAdapterRP getMouseAdapterRP() {
		return mouseAdapterRP;
	}

	public MouseMotionAdapterRP getMouseMotionAdapterRP() {
		return mouseMotionAdapterRP;
	}

	public MAdapter getmAdapter() {
		return mAdapter;
	}

	public BrowseAction getBrowseAction() {
		return browseAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	public Cut getCutAction() {
		return cutAction;
	}

	public SaveAs getSaveAs() {
		return saveAs;
	}

	public Save getSave() {
		return save;
	}

	public SwitchWorkspace getSwitchWorkspace() {
		return switchWorkspace;
	}

	public ImportDocAction getImportDocAction() {
		return importDocAction;
	}
	
}