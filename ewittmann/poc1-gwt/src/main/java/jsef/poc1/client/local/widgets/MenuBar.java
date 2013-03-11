package jsef.poc1.client.local.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Implements the menu bar.
 *
 * @author eric.wittmann@redhat.com
 */
public class MenuBar extends Panel {

	private List<Widget> children = new ArrayList<Widget>();
	private Map<String, MenuBar> subMenuIndex = new HashMap<String, MenuBar>();

	/**
	 * Constructor.
	 */
	public MenuBar() {
		setElement(Document.get().createULElement());
	}

	/**
	 * @see com.google.gwt.user.client.ui.Panel#add(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void add(Widget w) {
	    throw new RuntimeException("Use addMenuItem() or addSubMenu()");
	}

	/**
	 * Adds a menu item.
	 * @param parentId
	 * @param url
	 * @param displayName
	 * @param active
	 */
	public void addMenuItem(String parentId, String url, String displayName, boolean active) {
	    MenuBar parent;
	    if (parentId == null || parentId.trim().length() == 0) {
	        parent = this;
	    } else {
	        parent = subMenuIndex.get(parentId);
	    }
	    parent.addMenuItem(url, displayName, active);
	}

	/**
	 * Adds a menu item.
	 * @param url
	 * @param displayName
	 * @param active
	 */
	protected void addMenuItem(String url, String displayName, boolean active) {
	    Anchor w = new Anchor(displayName);
	    w.setHref(url);
        children.add(w);
        Element li = Document.get().createLIElement().cast();
        DOM.appendChild(li, w.getElement());
        DOM.appendChild(getElement(), li);
        if (active)
            li.setClassName("active");
        adopt(w);
	}

	/**
	 * Adds a sub-menu.
	 * @param id
	 * @param displayName
	 */
	public void addSubMenu(String id, String displayName) {
	    MenuBar w = new MenuBar();
	    w.getElement().setClassName("dropdown-menu");
        children.add(w);
        Element li = Document.get().createLIElement().cast();
        li.setClassName("dropdown");
        Element a = Document.get().createAnchorElement().cast();
        a.setClassName("dropdown-toggle");
        a.setAttribute("data-toggle", "dropdown");
        a.setAttribute("href", "#");
        a.setInnerHTML(displayName + "<b class=\"caret\"></b>");

        DOM.appendChild(li, a);
        DOM.appendChild(li, w.getElement());
        DOM.appendChild(getElement(), li);
        adopt(w);

        subMenuIndex.put(id, w);
	}

	/**
	 * @see com.google.gwt.user.client.ui.Panel#clear()
	 */
	@Override
	public void clear() {
	    // Not implemented
	}

	/**
	 * @see com.google.gwt.user.client.ui.HasWidgets#iterator()
	 */
	@Override
	public Iterator<Widget> iterator() {
		return this.children.iterator();
	}

	/**
	 * @see com.google.gwt.user.client.ui.Panel#remove(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public boolean remove(Widget w) {
	    // not implemented
	    return false;
	}

}
