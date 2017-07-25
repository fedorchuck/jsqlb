/*
 * Copyright 2017 Volodymyr Fedorchuk <vl.fedorchuck@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.fedorchuck.jsqlb;

/**
 * @author <a href="http://vl-fedorchuck.rhcloud.com/">Volodymyr Fedorchuk</a>.
 */
@SuppressWarnings("SameParameterValue")
public abstract class JSQLBuilder {

    public abstract JSQLBuilder select(Column... columns);

    public abstract JSQLBuilder from(Table... tables);

    public abstract JSQLBuilder insert(Table table, Column... column);

    public abstract JSQLBuilder update(Table table, Column... columns);

    public abstract JSQLBuilder update(Table table, SET... set);

    public abstract JSQLBuilder delete(Table table);

    public abstract JSQLBuilder where(String conditionalExpression);

    public abstract JSQLBuilder where(ConditionalExpression conditionalExpression);

    public abstract JSQLBuilder returning(Column... columns);

    public abstract String getSQL();

    public abstract void bufferCleanup();
}
