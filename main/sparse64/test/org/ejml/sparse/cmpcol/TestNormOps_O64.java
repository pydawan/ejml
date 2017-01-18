/*
 * Copyright (c) 2009-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
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

package org.ejml.sparse.cmpcol;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRow_F64;
import org.ejml.data.SMatrixCmpC_F64;
import org.ejml.dense.row.NormOps_R64;
import org.ejml.sparse.ConvertSparseMatrix_F64;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Peter Abeles
 */
public class TestNormOps_O64 {

    Random rand = new Random(234);

    @Test
    public void fastNormF() {
        for( int length : new int[]{0,2,6,15,30} ) {
            SMatrixCmpC_F64 A = RandomMatrices_O64.uniform(6,6,length,rand);
            DMatrixRow_F64  Ad = ConvertSparseMatrix_F64.convert(A,(DMatrixRow_F64)null);

            double found = NormOps_O64.fastNormF(A);
            double expected = NormOps_R64.fastNormF(Ad);

            assertEquals(expected,found, UtilEjml.TEST_F64);
        }
    }

    @Test
    public void normF() {
        for( int length : new int[]{0,2,6,15,30} ) {
            SMatrixCmpC_F64 A = RandomMatrices_O64.uniform(6,6,length,rand);
            DMatrixRow_F64  Ad = ConvertSparseMatrix_F64.convert(A,(DMatrixRow_F64)null);

            double found = NormOps_O64.normF(A);
            double expected = NormOps_R64.normF(Ad);

            assertEquals(expected,found, UtilEjml.TEST_F64);
        }
    }
}