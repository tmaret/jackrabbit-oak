/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.jackrabbit.oak.plugins.document;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.jackrabbit.oak.plugins.document.util.Utils;

/**
 * Implements a comparator, which sorts paths according to 1) their depth
 * (highest first) and 2) the paths natural ordering.
 */
public class PathComparator implements Comparator<Path>, Serializable {

    private static final long serialVersionUID = -1523171906146067782L;

    public static final Comparator<Path> INSTANCE = new PathComparator();

    private PathComparator() {
    }

    @Override
    public int compare(Path p1, Path p2) {
        int d1 = p1.getDepth();
        int d2 = p2.getDepth();
        if (d1 != d2) {
            return Integer.signum(d2 - d1);
        }
        return p1.compareTo(p2);
    }
}
