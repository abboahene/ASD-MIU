package orderSystem.visitor;

import orderSystem.CooperateOrder;
import orderSystem.IndividualOrder;
import orderSystem.InternalOrder;

public interface Visitor {
    void visit(CooperateOrder order);
    void visit(IndividualOrder order);
    void visit(InternalOrder order);
}
