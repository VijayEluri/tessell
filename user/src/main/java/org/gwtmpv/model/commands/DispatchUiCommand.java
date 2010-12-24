package org.gwtmpv.model.commands;

import static org.gwtmpv.model.properties.NewProperty.booleanProperty;

import org.gwtmpv.dispatch.client.events.DispatchUnhandledFailureEvent;
import org.gwtmpv.dispatch.client.util.OutstandingDispatchAsync;
import org.gwtmpv.dispatch.shared.Action;
import org.gwtmpv.dispatch.shared.Result;
import org.gwtmpv.model.properties.BooleanProperty;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;

/** Maintains the state of a {@code gwt-dispatch}-style UiCommand. */
public abstract class DispatchUiCommand<A extends Action<R>, R extends Result> extends UiCommand {

  private final EventBus eventBus;
  private final OutstandingDispatchAsync async;
  private final BooleanProperty active = booleanProperty("active", false);

  public DispatchUiCommand(EventBus eventBus, OutstandingDispatchAsync async) {
    this.eventBus = eventBus;
    this.async = async;
  }

  @Override
  protected final void doExecute() {
    if (active.isTrue()) {
      return;
    }
    A action = createAction();
    if (action != null) {
      active.set(true);
      // It would be nice to use a SuccessCallback, but we need to know
      // when the failure happened to toggle active back to false
      async.execute(action, new AsyncCallback<R>() {
        public void onSuccess(R result) {
          onResult(result);
          active.set(false);
        }

        public void onFailure(Throwable caught) {
          DispatchUiCommand.this.onFailure(caught);
          active.set(false);
        }
      });
    }
  }

  /** Implemented by subclasses to create the action object. */
  protected abstract A createAction();

  /** Implemented by subclasses to handle a successful result. */
  protected abstract void onResult(R result);

  /** Fires a {@link DispatchUnhandledFailureEvent} on failures, can be overridden by subclasses if needed. */
  protected void onFailure(Throwable caught) {
    if (eventBus != null) {
      DispatchUnhandledFailureEvent.fire(eventBus, null, caught, null);
    }
  }

  /** @return whether the call is currently active */
  public BooleanProperty active() {
    return active;
  }

}
