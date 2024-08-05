package orderSystem.visitor;

import orderSystem.CooperateOrder;
import orderSystem.IndividualOrder;
import orderSystem.InternalOrder;
import orderSystem.OrderCollection;

import java.util.HashMap;
import java.util.Map;

public class CountOrderTypeVisitor implements Visitor {

    private Map<String, Integer> map;

    public CountOrderTypeVisitor(){
        map  = new HashMap<>();
        map.put("Cooperate Order", 0);
        map.put("Individual Order", 0);
        map.put("Internal Order", 0);
    }


    public void visit(CooperateOrder order){
        int count = map.get("Cooperate Order");
        map.put("Cooperate Order", count + 1);
    }

    @Override
    public void visit(IndividualOrder order) {
        int count = map.get("Individual Order");
        map.put("Individual Order", count + 1);
    }

    @Override
    public void visit(InternalOrder order) {
        int count = map.get("Internal Order");
        map.put("Internal Order", count + 1);
    }

    public void print(){
        for(String key: map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
    }
}
