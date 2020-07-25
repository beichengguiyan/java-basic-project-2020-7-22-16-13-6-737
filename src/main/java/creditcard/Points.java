package creditcard;

import java.math.BigDecimal;

public abstract class Points {
    protected abstract BigDecimal getDefaultPoints(User user);
    protected abstract Boolean inPointsScope(User user);

    public BigDecimal getPoints(User user) {
        if (inPointsScope(user)) {
            return getDefaultPoints(user);
        }
        return new BigDecimal(0);
    }
}
