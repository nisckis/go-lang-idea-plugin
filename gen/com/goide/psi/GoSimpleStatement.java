// This is a generated file. Not intended for manual editing.
package com.goide.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GoSimpleStatement extends GoStatement {

  @Nullable
  GoExpression getExpression();

  @Nullable
  GoShortVarDeclaration getShortVarDeclaration();

  @Nullable
  PsiElement getMinusMinus();

  @Nullable
  PsiElement getPlusPlus();

}
