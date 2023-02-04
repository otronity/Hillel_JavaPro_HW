package orderservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {

    public String shopName;
    public String name;
    public double price;
    public int cnt;

}
