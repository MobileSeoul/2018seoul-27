// Generated code from Butter Knife. Do not modify!
package com.meanu.sijangseoul;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131296355;

  private View view2131296304;

  @UiThread
  public SplashActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SplashActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.floatingButton, "field 'floatingButton' and method 'GoProductGirdFragment'");
    target.floatingButton = Utils.castView(view, R.id.floatingButton, "field 'floatingButton'", FloatingActionButton.class);
    view2131296355 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.GoProductGirdFragment(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonToResult, "field 'buttonToResult' and method 'GoSearchFragment'");
    target.buttonToResult = Utils.castView(view, R.id.buttonToResult, "field 'buttonToResult'", Button.class);
    view2131296304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.GoSearchFragment(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.floatingButton = null;
    target.buttonToResult = null;

    view2131296355.setOnClickListener(null);
    view2131296355 = null;
    view2131296304.setOnClickListener(null);
    view2131296304 = null;
  }
}
