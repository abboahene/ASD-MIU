package orderSystem.visitor;

import orderSystem.*;

public class NumberOfTVsVisitor implements Visitor {

    private int total;

    public NumberOfTVsVisitor(){

    }

    @Override
    public void visit(CooperateOrder order){
        for(Orderline orderline : order.getOrderlineList()){
            if(orderline.getProduct().getName().equals("TV")){
                total+=1;
            }
        }
    }

    @Override
    public void visit(IndividualOrder order) {
        for(Orderline orderline : order.getOrderlineList()){
            if(orderline.getProduct().getName().equals("TV")){
                total+=1;
            }
        }
    }

    @Override
    public void visit(InternalOrder order) {
        for(Orderline orderline : order.getOrderlineList()){
            if(orderline.getProduct().getName().equals("TV")){
                total+=1;
            }
        }
    }

    public void print(){
        System.out.println("No. of TVs: "+ total);
    }
}
