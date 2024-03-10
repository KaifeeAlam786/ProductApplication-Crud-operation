package in.kaifee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.kaifee.entity.Product;
import in.kaifee.repo.ProductRespository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRespository repo;
	
	@GetMapping("/")
	public String loadPage(Product p,Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	@PostMapping("/products")
	public String saveProduct(@Validated @ModelAttribute("product")Product p,BindingResult res, Model model) {
		if(res.hasErrors()) {
			return "index";
		}
		
		p=repo.save(p);
		if(p.getPid()!=null) {
			model.addAttribute("msg","Data Save...");
		}
		return "index";
	}
	
	@GetMapping("/record")
	public String viewProduct(Model model) {
		
		List<Product> all = repo.findAll();
		model.addAttribute("p",all);
		return "data";
	}
	@GetMapping("/delete")
	public String  deleteProduct(@RequestParam("pid") Integer pid,Model model) {
		
		repo.deleteById(pid);
		model.addAttribute("msg", "Product Deleted...");
		model.addAttribute("p",repo.findAll());
		
		return "data";
	}
	@GetMapping("/edit")
	public String editProduct(@RequestParam("pid") Integer pid,Model model) {
		
		Optional<Product> byId = repo.findById(pid);
		if(byId.isPresent()) {
			Product product = byId.get();
			model.addAttribute("product", product );
		}
		return "index";
	}
	
	
	

}
