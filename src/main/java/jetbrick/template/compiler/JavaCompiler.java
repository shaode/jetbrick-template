/**
 * jetbrick-template
 * http://subchen.github.io/jetbrick-template/
 *
 * Copyright 2010-2013 Guoqiang Chen. All rights reserved.
 * Email: subchen@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrick.template.compiler;

import java.io.File;
import jetbrick.template.compiler.jdk.JdkCompiler;

public abstract class JavaCompiler {
    protected final JetTemplateClassLoader classloader;

    public static JavaCompiler create(JetTemplateClassLoader classloader) {
        return new JdkCompiler(classloader);
    }

    protected JavaCompiler(JetTemplateClassLoader classloader) {
        this.classloader = classloader;
    }

    public final File getGenerateJavaSourceFile(String qualifiedClassName) {
        String fileName = qualifiedClassName.replace('.', '/');
        return new File(classloader.getClasspath(), fileName + ".java");
    }

    public final File getGenerateJavaClassFile(String qualifiedClassName) {
        String fileName = qualifiedClassName.replace('.', '/');
        return new File(classloader.getClasspath(), fileName + ".class");
    }

    public abstract Class<?> compile(String qualifiedClassName, String source);

}