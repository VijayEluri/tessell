package org.tessell.widgets;

import org.tessell.place.history.GwtHistory;
import org.tessell.place.history.IsHistory;
import org.tessell.util.cookies.facade.GwtCookies;
import org.tessell.util.cookies.facade.IsCookies;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.CellTable.Resources;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestOracle;

/** A Widget factory. */
public class GwtWidgetsProvider implements WidgetsProvider {

  private final GwtWindow window = new GwtWindow();
  private final GwtCookies cookies = new GwtCookies();
  private final GwtHistory history = new GwtHistory();
  private final IsAbsolutePanel root = new GwtAbsolutePanelDelegate(RootPanel.get());

  @Override
  public IsTimer newTimer(Runnable runnable) {
    return new GwtTimer(runnable);
  }

  @Override
  public IsWindow getWindow() {
    return window;
  }

  @Override
  public IsElement newElement(String tag) {
    return new GwtElement(DOM.createElement(tag));
  }

  @Override
  public IsTextBox newTextBox() {
    return new GwtTextBox();
  }

  @Override
  public IsTextList newTextList() {
    return new TextList();
  }

  @Override
  public IsAnchor newAnchor() {
    return new GwtAnchor();
  }

  @Override
  public IsHyperlink newHyperline() {
    return new GwtHyperlink();
  }

  @Override
  public IsInlineHyperlink newInlineHyperlink() {
    return new GwtInlineHyperlink();
  }

  @Override
  public IsInlineLabel newInlineLabel() {
    return new GwtInlineLabel();
  }

  @Override
  public IsImage newImage() {
    return new GwtImage();
  }

  @Override
  public IsFlowPanel newFlowPanel() {
    return new GwtFlowPanel();
  }

  @Override
  public IsScrollPanel newScrollPanel() {
    return new GwtScrollPanel();
  }

  @Override
  public IsTabLayoutPanel newTabLayoutPanel(double barHeight, Unit barUnit) {
    return new GwtTabLayoutPanel(barHeight, barUnit);
  }

  @Override
  public IsFadingDialogBox newFadingDialogBox() {
    return new GwtFadingDialogBox();
  }

  @Override
  public IsHTML newHTML() {
    return new GwtHTML();
  }

  @Override
  public IsHTMLPanel newHTMLPanel(String html) {
    return new GwtHTMLPanel(html);
  }

  @Override
  public <T> IsCellTable<T> newCellTable() {
    return new GwtCellTable<T>();
  }

  @Override
  public <T> IsCellTable<T> newCellTable(int pageSize, Resources resources) {
    return new GwtCellTable<T>(pageSize, resources);
  }

  @Override
  public <T> IsCellList<T> newCellList(Cell<T> cell) {
    return new GwtCellList<T>(cell);
  }

  @Override
  public IsCheckBox newCheckBox() {
    return new GwtCheckBox();
  }

  @Override
  public IsPasswordTextBox newPasswordTextBox() {
    return new GwtPasswordTextBox();
  }

  @Override
  public IsPopupPanel newPopupPanel() {
    return new GwtPopupPanel();
  }

  @Override
  public IsFocusPanel newFocusPanel() {
    return new GwtFocusPanel();
  }

  @Override
  public IsLabel newLabel() {
    return new GwtLabel();
  }

  @Override
  public IsCookies getCookies() {
    return cookies;
  }

  @Override
  public IsAnimation newAnimation(AnimationLogic logic) {
    return new GwtAnimation(logic);
  }

  @Override
  public IsHistory getHistory() {
    return history;
  }

  @Override
  public IsAbsolutePanel newAbsolutePanel() {
    return new GwtAbsolutePanel();
  }

  @Override
  public IsAbsolutePanel getRootPanel() {
    return root;
  }

  @Override
  public IsInlineHTML newInlineHTML() {
    return new GwtInlineHTML();
  }

  @Override
  public IsButton newButton() {
    return new GwtButton();
  }

  @Override
  public IsSuggestBox newSuggestBox(SuggestOracle oracle) {
    return new GwtSuggestBox(oracle);
  }

  @Override
  public IsDockLayoutPanel newDockLayoutPanel(Unit unit) {
    return new GwtDockLayoutPanel(unit);
  }

  @Override
  public IsSimplePanel newSimplePanel() {
    return new GwtSimplePanel();
  }

  @Override
  public IsListBox newListBox() {
    return new GwtListBox();
  }

  @Override
  public <T> IsDataGrid<T> newDataGrid() {
    return new GwtDataGrid<T>();
  }

  @Override
  public <T> IsDataGrid<T> newDataGrid(int pageSize, DataGrid.Resources resources) {
    return new GwtDataGrid<T>(pageSize, resources);
  }

  @Override
  public IsResizeLayoutPanel newResizeLayoutPanel() {
    return new GwtResizeLayoutPanel();
  }

}