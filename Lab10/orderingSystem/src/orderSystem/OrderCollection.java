package orderSystem;

import orderSystem.visitor.CountOrderTypeVisitor;
import orderSystem.visitor.NumberOfTVsVisitor;
import orderSystem.visitor.TotalAmountVisitor;

import java.util.ArrayList;
import java.util.List;

public class OrderCollection {
    List<Order> orderList;

    OrderCollection(){
        this.orderList = new ArrayList<>();
    }
    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public void printOrderTypeCounts() {
        CountOrderTypeVisitor visitor = new CountOrderTypeVisitor();
        for(Order order : orderList){
           if(order instanceof CooperateOrder){
              CooperateOrder cooperateOrder =  (CooperateOrder) order;
              cooperateOrder.accept(visitor);
           }
           else if(order instanceof IndividualOrder){
               IndividualOrder individualOrder =  (IndividualOrder) order;
               individualOrder.accept(visitor);
           }else if( order instanceof InternalOrder){
               InternalOrder internalOrder =  (InternalOrder) order;
               internalOrder.accept(visitor);
           }
        }
        visitor.print();
    }

    public void printTotalAmount() {
        TotalAmountVisitor visitor = new TotalAmountVisitor();
        for(Order order : orderList){
            if(order instanceof CooperateOrder){
                CooperateOrder cooperateOrder =  (CooperateOrder) order;
                cooperateOrder.accept(visitor);
            }
            else if(order instanceof IndividualOrder){
                IndividualOrder individualOrder =  (IndividualOrder) order;
                individualOrder.accept(visitor);
            }else if( order instanceof InternalOrder){
                InternalOrder internalOrder =  (InternalOrder) order;
                internalOrder.accept(visitor);
            }
        }
        visitor.print();
    }

    public void printNumberOfTVs() {
        NumberOfTVsVisitor visitor = new NumberOfTVsVisitor();
        for(Order order : orderList){
            if(order instanceof CooperateOrder){
                CooperateOrder cooperateOrder =  (CooperateOrder) order;
                cooperateOrder.accept(visitor);
            }
            else if(order instanceof IndividualOrder){
                IndividualOrder individualOrder =  (IndividualOrder) order;
                individualOrder.accept(visitor);
            }else if( order instanceof InternalOrder){
                InternalOrder internalOrder =  (InternalOrder) order;
                internalOrder.accept(visitor);
            }
        }
        visitor.print();
    }

}
