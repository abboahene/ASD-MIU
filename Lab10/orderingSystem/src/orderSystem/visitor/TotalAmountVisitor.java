package orderSystem.visitor;

import orderSystem.CooperateOrder;
import orderSystem.IndividualOrder;
import orderSystem.InternalOrder;

import java.util.HashMap;
import java.util.Map;

public class TotalAmountVisitor implements Visitor {

    private double total;

    public TotalAmountVisitor(){

    }

    @Override
    public void visit(CooperateOrder order){
        total += order.getAmount();
    }

    @Override
    public void visit(IndividualOrder order) {
        total += order.getAmount();
    }

    @Override
    public void visit(InternalOrder order) {
        total += order.getAmount();
    }

    public void print(){
        System.out.println("Total amount: "+ total);
    }
}
