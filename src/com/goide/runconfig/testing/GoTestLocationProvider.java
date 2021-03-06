/*
 * Copyright 2013-2014 Sergey Ignatov, Alexander Zolotov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.runconfig.testing;

import com.goide.psi.GoFunctionDeclaration;
import com.goide.stubs.index.GoFunctionIndex;
import com.intellij.execution.Location;
import com.intellij.execution.PsiLocation;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.testIntegration.TestLocationProvider;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class GoTestLocationProvider implements TestLocationProvider {
  public static final String PROTOCOL = "gotest";

  @NotNull
  @Override
  public List<Location> getLocation(@NotNull String protocolId, @NotNull String locationData, @NotNull final Project project) {
    if (!PROTOCOL.equals(protocolId)) {
      return Collections.emptyList();
    }
    return ContainerUtil.map(GoFunctionIndex.find(locationData, project, GlobalSearchScope.projectScope(project)), new Function<GoFunctionDeclaration, Location>() {
      @Override
      public Location fun(GoFunctionDeclaration declaration) {
        return PsiLocation.fromPsiElement(project, declaration);
      }
    });
  }
}
