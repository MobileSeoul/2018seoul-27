// Generated code from Butter Knife. Do not modify!
package com.meanu.sijangseoul.Search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.meanu.sijangseoul.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchFragment_ViewBinding implements Unbinder {
  private SearchFragment target;

  @UiThread
  public SearchFragment_ViewBinding(SearchFragment target, View source) {
    this.target = target;

    target.editText = Utils.findRequiredViewAsType(source, R.id.text_intput_search, "field 'editText'", TextInputEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editText = null;
  }
}
