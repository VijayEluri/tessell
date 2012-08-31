package org.tessell.widgets;

import java.util.ArrayList;
import java.util.List;

import org.tessell.gwt.user.client.ui.IsWidget;

public class StubRowTable extends StubWidget implements IsRowTable {

  private final List<IsWidget> headers = new ArrayList<IsWidget>();
  private final List<IsWidget> rows = new ArrayList<IsWidget>();

  @Override
  public void addHeader(final com.google.gwt.user.client.ui.IsWidget isWidget) {
    headers.add((IsWidget) isWidget);
  }

  @Override
  public void addRow(final com.google.gwt.user.client.ui.IsWidget isWidget) {
    rows.add((IsWidget) isWidget);
  }

  public List<IsWidget> getHeaders() {
    return headers;
  }

  public List<IsWidget> getRows() {
    return rows;
  }

  @Override
  public void replaceRow(final int i, final com.google.gwt.user.client.ui.IsWidget isWidget) {
    rows.remove(i);
    rows.add(i, (IsWidget) isWidget);
  }

  @Override
  public void removeRow(final int i) {
    rows.remove(i);
  }

  @Override
  public void removeRow(com.google.gwt.user.client.ui.IsWidget view) {
    removeRow(rows.indexOf(view));
  }

  @Override
  public int size() {
    return rows.size();
  }

  @Override
  public void clearRows() {
    while (rows.size() > 0) {
      removeRow(0);
    }
  }

  @Override
  public void insertRow(final int i, final com.google.gwt.user.client.ui.IsWidget isWidget) {
    rows.add(i, (IsWidget) isWidget);
  }

  @Override
  protected IsWidget findInChildren(String id) {
    IsWidget a = findInChildren(headers.iterator(), id);
    if (a != null) {
      return a;
    }
    return findInChildren(rows.iterator(), id);
  }

}
