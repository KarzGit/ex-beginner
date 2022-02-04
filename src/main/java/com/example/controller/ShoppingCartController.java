package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {

	@Autowired
	private ServletContext application;
	private HttpSession session;

	@RequestMapping("")
	public String index(Model model) {
		Item item1 = new Item();
		item1.setName("手帳ノート");
		item1.setPrice(1000);
		Item item2 = new Item();
		item1.setName("文房具セット");
		item1.setPrice(1500);
		Item item3 = new Item();
		item1.setName("ファイル");
		item1.setPrice(2000);

		List<Item> itemList = new LinkedList<>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		application.setAttribute("itemList", itemList);

		List<Item> itemListInCart = new LinkedList<>();
		session.setAttribute("item", itemListInCart);

		Integer total = 0;
		for (int i = 0; i < itemListInCart.size(); i++) {
			Item item = itemListInCart.get(i);
			total += item.getPrice();
		}
		model.addAttribute("total", total);
		return "item-and-cart";
	}
}
