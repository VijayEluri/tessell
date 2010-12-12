package org.gwtmpv.widgets;

public interface IsAbsolutePanel extends IsComplexPanel {

  void add(IsWidget w, int left, int top);

  int getIsWidgetLeft(IsWidget w);

  int getIsWidgetTop(IsWidget w);

  void insert(IsWidget w, int beforeIndex);

  void insert(IsWidget w, int left, int top, int beforeIndex);

  void setWidgetPosition(IsWidget w, int left, int top);

}
