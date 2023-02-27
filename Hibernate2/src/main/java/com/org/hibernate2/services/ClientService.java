package com.org.hibernate2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.hibernate2.dto.*;
import com.org.hibernate2.model.*;
import com.org.hibernate2.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final OrderRepoitory orderRepoitory;
    private final Order_ItemRepository  orderItemRepository;
    private final ObjectMapper objectMapper;


    @Transactional
    public ProductDto addProduct(ProductDto productDto){
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }

    @Transactional
    public AddressDto addAddress(AddressDto addressDto){
        Address address = objectMapper.convertValue(addressDto, Address.class);
        addressRepository.save(address);
        addressDto.setId(address.getId());
        return addressDto;
    }

    @Transactional
    public OrderDto addOrder(OrderDto orderDto){
        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepoitory.save(order);
        orderDto.setId(order.getId());

        List<Order_ItemDto> orderItemsDto = orderDto.getOrderItems();
        List<Order_Item> orderItems = new ArrayList<>();
        for (Order_ItemDto orderItemDto : orderItemsDto) {
            orderItemDto.setOrder(order);
            Order_Item orderItem = objectMapper.convertValue(orderItemDto, Order_Item.class);
            orderItemRepository.save(orderItem);
            orderItems.add(orderItem);
            orderItemDto.setId(order.getId());

        }
        order.setOrderItems(orderItems);

        return orderDto;
    }

    @Transactional
    public ClientDto addClient(ClientDto clientDto){
        if (clientDto != null) {

            Client client = objectMapper.convertValue(clientDto, Client.class);
            clientRepository.save(client);
            clientDto.setId(client.getId());
        } else {
            log.info("No data to create Client");

        }
        return clientDto;
    }

    public ClientOrdersDto getFullInfoById(int id) {
        ClientOrdersDto clientOrdersDto = new ClientOrdersDto();

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Client with ID = " + id));
        if(client != null) {
            clientOrdersDto.setId(client.getId());
            clientOrdersDto.setName(client.getName());
            clientOrdersDto.setPhone(client.getPhone());
            clientOrdersDto.setEmail(client.getEmail());

            AddressDto address = objectMapper.convertValue(client.getAddress(), AddressDto.class);
            List<OrderDto> allOrdersByClient = orderRepoitory.findAllByClient(client)
                    .stream().map(order -> objectMapper.convertValue(order, OrderDto.class))
                    .collect(Collectors.toList());

            for (OrderDto orderDto : allOrdersByClient) {
                List<Order_Item> allorderitems = orderItemRepository.findAllByOrderId(orderDto.getId());
                List<Order_ItemDto> allorderitemsdto = new ArrayList<>();
                for (Order_Item allorderitem : allorderitems) {
                    allorderitemsdto.add(objectMapper.convertValue(allorderitem, Order_ItemDto.class));
                }
                orderDto.setOrderItems(allorderitemsdto);
            }

            clientOrdersDto.setOrders(allOrdersByClient);
            clientOrdersDto.setAddress(address);

        }

        return clientOrdersDto;
    }

    public ClientOrdersIdDto  getInfoById(int id){
        ClientOrdersIdDto clientOrdersIdDto = new ClientOrdersIdDto();

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Client with ID = " + id));
        if(client != null) {
            clientOrdersIdDto.setId(client.getId());
            clientOrdersIdDto.setName(client.getName());
            clientOrdersIdDto.setPhone(client.getPhone());
            clientOrdersIdDto.setEmail(client.getEmail());

            List<Integer> allOrdersIdByClient = orderRepoitory.findAllByClient(client)
                    .stream().map(order -> objectMapper.convertValue(order, OrderDto.class).getId())
                    .collect(Collectors.toList());
            clientOrdersIdDto.setOrders(allOrdersIdByClient);
        }
        return clientOrdersIdDto;
    }

    public ClientInfoDto getClientInfo(int id){
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Client with ID = " + id));
        if(client != null) {
            clientInfoDto.setId(client.getId());
            clientInfoDto.setName(client.getName());
            clientInfoDto.setPhone(client.getPhone());
            clientInfoDto.setEmail(client.getEmail());
            AddressDto addressDto = objectMapper.convertValue(client.getAddress(), AddressDto.class);
            clientInfoDto.setAddressDto(addressDto);
        }

        return clientInfoDto;
    }
}
