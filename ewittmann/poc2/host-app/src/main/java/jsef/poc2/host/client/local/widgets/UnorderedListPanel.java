package jsef.poc2.host.client.local.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Implements a simple unordered list (ul).
 *
 * @author eric.wittmann@redhat.com
 */
public class UnorderedListPanel extends Panel implements IndexedPanel {

	private List<Widget> children = new ArrayList<Widget>();
	private Map<Widget, Element> wrapperMap = new HashMap<Widget, Element>();

	/**
	 * Constructor.
	 */
	public UnorderedListPanel() {
		setElement(Document.get().createULElement());
	}

	/**
	 * @see com.google.gwt.user.client.ui.Panel#add(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void add(Widget w) {
		if (w == null)
			throw new NullPointerException("Cannot add a null widget.");
		w.removeFromParent();
		children.add(w);
		Element li = Document.get().createLIElement().cast();
		wrapperMap.put(w, li);
		DOM.appendChild(li, w.getElement());
		DOM.appendChild(getElement(), li);
		adopt(w);
	}

	/**
	 * Sets the 'class' attribute on the "li" wrapper for the
	 * given wiget.
	 * @param w
	 * @param theClass
	 */
	public void setLiClass(Widget w, String theClass) {
	    if (this.wrapperMap.containsKey(w)) {
	        this.wrapperMap.get(w).setClassName(theClass);
	    }
	}

	/**
	 * Sets the 'class' attribute on the "li" wrapper for the
	 * widget at the given index.
	 * @param index
	 * @param theClass
	 */
	public void setLiClass(int index, String theClass) {
	    Widget widget = this.getWidget(index);
	    if (widget != null) {
	        this.setLiClass(widget, theClass);
	    }
	}

	/**
	 * @see com.google.gwt.user.client.ui.Panel#clear()
	 */
	@Override
	public void clear() {
		List<Widget> childrenClone = new ArrayList<Widget>(this.children);
		for (Widget widget : childrenClone) {
			this.remove(widget);
		}
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
		if (!this.children.contains(w))
			return false;
		orphan(w);
		Element liWrapper = this.wrapperMap.get(w);
		getElement().removeChild(liWrapper);
		this.children.remove(w);
		this.wrapperMap.remove(w);
		return true;
	}

	/**
	 * @see com.google.gwt.user.client.ui.IndexedPanel#getWidget(int)
	 */
	@Override
	public Widget getWidget(int index) {
		return this.children.get(index);
	}

	/**
	 * @see com.google.gwt.user.client.ui.IndexedPanel#getWidgetCount()
	 */
	@Override
	public int getWidgetCount() {
		return this.children.size();
	}

	/**
	 * @see com.google.gwt.user.client.ui.IndexedPanel#getWidgetIndex(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public int getWidgetIndex(Widget child) {
		for (int i=0; i < this.children.size(); i++) {
			if (this.children.get(i) == child)
				return i;
		}
		return -1;
	}

	/**
	 * @see com.google.gwt.user.client.ui.IndexedPanel#remove(int)
	 */
	@Override
	public boolean remove(int index) {
		return remove(this.children.get(index));
	}

}
