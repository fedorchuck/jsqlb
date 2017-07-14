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
public abstract class ConditionalExpression {
    public abstract ConditionalExpression moreThen();

    public abstract ConditionalExpression moreThen(String value);

    public abstract ConditionalExpression lessThen();

    public abstract ConditionalExpression lessThen(String value);

    public abstract ConditionalExpression equal();

    public abstract ConditionalExpression equal(String value);

    public abstract ConditionalExpression and(Column column);

    public abstract ConditionalExpression or(Column column);

    public abstract String getSQL();

    public abstract void flush();
}
