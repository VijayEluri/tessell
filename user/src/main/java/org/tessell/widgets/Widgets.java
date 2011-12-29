package org.tessell.widgets;

import org.tessell.place.history.IsHistory;
import org.tessell.util.cookies.facade.IsCookies;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle;

/** A Widget factory. */
public class Widgets {

  private static WidgetsProvider provider;

  static {
    if (GWT.isClient()) {
      setProvider(new GwtWidgetsProvider());
    }
  }

  public static void setProvider(WidgetsProvider provider) {
    Widgets.provider = provider;
  }

  public static IsDockLayoutPanel newDockLayoutPanel(Unit unit) {
    return provider.newDockLayoutPanel(unit);
  }

  public static IsSimplePanel newSimplePanel() {
    return provider.newSimplePanel();
  }

  public static IsAbsolutePanel getRootPanel() {
    return provider.getRootPanel();
  }

  public static IsCookies getCookies() {
    return provider.getCookies();
  }

  public static IsTimer newTimer(Runnable runnable) {
    return provider.newTimer(runnable);
  }

  public static IsAnimation newAnimation(AnimationLogic logic) {
    return provider.newAnimation(logic);
  }

  public static IsWindow getWindow() {
    return provider.getWindow();
  }

  public static IsHistory getHistory() {
    return provider.getHistory();
  }

  public static IsElement newElement(String tag) {
    return provider.newElement(tag);
  }

  public static IsCheckBox newCheckBox() {
    return provider.newCheckBox();
  }

  public static IsTextBox newTextBox() {
    return provider.newTextBox();
  }

  public static IsPasswordTextBox newPasswordTextBox() {
    return provider.newPasswordTextBox();
  }

  public static IsTextList newTextList() {
    return provider.newTextList();
  }

  public static IsAnchor newAnchor() {
    return provider.newAnchor();
  }

  public static IsButton newButton() {
    return provider.newButton();
  }

  public static IsHyperlink newHyperline() {
    return provider.newHyperline();
  }

  public static IsInlineHyperlink newInlineHyperlink() {
    return provider.newInlineHyperlink();
  }

  public static IsInlineLabel newInlineLabel() {
    return provider.newInlineLabel();
  }

  public static IsInlineHTML newInlineHTML() {
    return provider.newInlineHTML();
  }

  public static IsInlineHTML newInlineHTML(String html) {
    IsInlineHTML h = provider.newInlineHTML();
    h.setHTML(html);
    return h;
  }

  public static IsInlineHTML newInlineHTML(SafeHtml html) {
    IsInlineHTML h = provider.newInlineHTML();
    h.setHTML(html.asString());
    return h;
  }

  public static IsLabel newLabel() {
    return provider.newLabel();
  }

  public static IsListBox newListBox() {
    return provider.newListBox();
  }

  public static IsImage newImage() {
    return provider.newImage();
  }

  public static IsFlowPanel newFlowPanel() {
    return provider.newFlowPanel();
  }

  public static IsFlowPanel newFlowPanel(IsWidget... widgets) {
    IsFlowPanel p = provider.newFlowPanel();
    for (IsWidget widget : widgets) {
      p.add(widget);
    }
    return p;
  }

  public static IsScrollPanel newScrollPanel() {
    return provider.newScrollPanel();
  }

  public static IsTabLayoutPanel newTabLayoutPanel(double barHeight, Unit barUnit) {
    return provider.newTabLayoutPanel(barHeight, barUnit);
  }

  public static IsFadingDialogBox newFadingDialogBox() {
    return provider.newFadingDialogBox();
  }

  public static IsHTML newHTML() {
    return provider.newHTML();
  }

  public static IsHTMLPanel newHTMLPanel(String html) {
    return provider.newHTMLPanel(html);
  }

  public static <T> IsCellTable<T> newCellTable() {
    return provider.newCellTable();
  }

  public static <T> IsCellTable<T> newCellTable(int pageSize, CellTable.Resources resources) {
    return provider.newCellTable(pageSize, resources);
  }

  public static <T> IsDataGrid<T> newDataGrid() {
    return provider.newDataGrid();
  }

  public static <T> IsDataGrid<T> newDataGrid(int pageSize, DataGrid.Resources resources) {
    return provider.newDataGrid(pageSize, resources);
  }

  public static <T> IsCellList<T> newCellList(Cell<T> cell) {
    return provider.newCellList(cell);
  }

  public static IsPopupPanel newPopupPanel() {
    return provider.newPopupPanel();
  }

  public static IsAbsolutePanel newAbsolutePanel() {
    return provider.newAbsolutePanel();
  }

  public static IsFocusPanel newFocusPanel() {
    return provider.newFocusPanel();
  }

  public static IsSuggestBox newSuggestBox() {
    return provider.newSuggestBox(new MultiWordSuggestOracle());
  }

  public static IsSuggestBox newSuggestBox(SuggestOracle oracle) {
    return provider.newSuggestBox(oracle);
  }

  public static IsResizeLayoutPanel newResizeLayoutPanel() {
    return provider.newResizeLayoutPanel();
  }

  public static IsResizeLayoutPanel newResizeLayoutPanel(IsWidget widget) {
    IsResizeLayoutPanel p = newResizeLayoutPanel();
    p.add(widget);
    return p;
  }

}