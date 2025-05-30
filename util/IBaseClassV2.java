package util;

/**
 * A generic interface for implementing and comparing different algorithm solutions.
 * Both methods are optional to implement - they have default implementations that throw UnsupportedOperationException.
 * 
 * @param <R> The return type of the algorithms
 * @param <P> The parameter type for the algorithms
 */
public interface IBaseClassV2<R, P> {
    /**
     * Intuitive/brute-force solution (optional)
     * @param param The input parameter
     * @return The result of the intuitive solution
     * @throws UnsupportedOperationException if not implemented
     */
    default R intution(P param) {
        throw new UnsupportedOperationException("intution() not implemented");
    }
    
    /**
     * Optimal solution (optional)
     * @param param The input parameter
     * @return The result of the optimal solution
     * @throws UnsupportedOperationException if not implemented
     */
    default R optimal(P param) {
        throw new UnsupportedOperationException("optimal() not implemented");
    }

}
