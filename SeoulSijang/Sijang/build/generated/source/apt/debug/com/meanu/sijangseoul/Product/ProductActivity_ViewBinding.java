// Generated code from Butter Knife. Do not modify!
package com.meanu.sijangseoul.Product;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.meanu.sijangseoul.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductActivity_ViewBinding implements Unbinder {
  private ProductActivity target;

  @UiThread
  public ProductActivity_ViewBinding(ProductActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductActivity_ViewBinding(ProductActivity target, View source) {
    this.target = target;

    target.myCurruntLocation = Utils.findRequiredViewAsType(source, R.id.myCurruntLocation, "field 'myCurruntLocation'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.myCurruntLocation = null;
  }
}
