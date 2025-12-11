
package com.mycompany.app;

import org.ejml.simple.SimpleMatrix;


public class EjmlExample {
    public static void main(String[] args) {
        // Create matrix A (3×3)
        double[][] aArray = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0,10.0}
        };
        SimpleMatrix A = new SimpleMatrix(aArray);

        // Create vector b (3×1)
        double[][] bArray = {
            {3.0},
            {3.0},
            {4.0}
        };
        SimpleMatrix b = new SimpleMatrix(bArray);

        // Solve A * x = b
        // In EJML: x = A.solve(b)
        SimpleMatrix x = A.solve(b);

        // Compute residual r = A * x - b
        SimpleMatrix r = A.mult(x).minus(b);

        // Display results
        System.out.println("Matrix A:");
        A.print();

        System.out.println("Vector b:");
        b.print();

        System.out.println("Solution x:");
        x.print();

        System.out.println("Residual r = A*x - b:");
        r.print();

        // Infinity norm of residual: use r.normF() as approximation or manually compute
        double infNorm = r.elementMaxAbs();
        System.out.printf("Infinity norm of residual: %.5f%n", infNorm);

        // Determinant of A
        double detA = A.determinant();
        System.out.printf("Determinant of A: %.5f%n", detA);

        // Transpose of A
        SimpleMatrix At = A.transpose();
        System.out.println("Transpose of A:");
        At.print();

        // Compute A * A^T
        SimpleMatrix product = A.mult(At);
        System.out.println("A * A^T:");
        product.print();
    }
}
