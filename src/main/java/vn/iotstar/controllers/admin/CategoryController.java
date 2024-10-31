package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.services.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
    public String listCategories(Model model, 
                             @RequestParam(defaultValue = "") String keyword,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "3") int size) {
        try {
            // Tạo Pageable với kích thước trang và số trang
            Pageable pageable = PageRequest.of(page, size);
            
            // Lấy dữ liệu phân trang
            Page<CategoryEntity> pageCategories = categoryService.findByNameContaining(keyword, pageable);
            
            // Thêm thông tin vào model
            model.addAttribute("categories", pageCategories.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalItems", pageCategories.getTotalElements());
            model.addAttribute("totalPages", pageCategories.getTotalPages());
            model.addAttribute("pageSize", size);
            model.addAttribute("keyword", keyword);

            // Thêm thông tin cho phân trang
            model.addAttribute("hasNext", pageCategories.hasNext());
            model.addAttribute("hasPrevious", pageCategories.hasPrevious());
            model.addAttribute("firstPage", 0);
            model.addAttribute("lastPage", pageCategories.getTotalPages() - 1);
            
            return "admin/categories/list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
	
	 

	@GetMapping("/add")
	public String showCreateForm(Model model) {
	    model.addAttribute("category", new CategoryEntity()); // Đổi tên thành "category"
	    return "admin/categories/add"; // Đường dẫn tới add.html
	}

	@PostMapping
	public String saveCategory(@ModelAttribute("category") CategoryEntity category,
	                         @RequestParam("imageFile") MultipartFile imageFile) {
	    try {
	        if (imageFile != null && !imageFile.isEmpty()) {
	            // Upload ảnh
	            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
	            
	            // Sử dụng đường dẫn tuyệt đối
	            String uploadDir = "src/main/resources/static/images";
	            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
	            
	            // Log để debug
	            System.out.println("Upload Path: " + uploadPath);
	            System.out.println("File Name: " + fileName);
	            
	            // Tạo thư mục nếu không tồn tại
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	                System.out.println("Directory created: " + uploadPath);
	            }
	            
	            // Copy file với full path
	            Path targetLocation = uploadPath.resolve(fileName);
	            System.out.println("Target Location: " + targetLocation);
	            
	            Files.copy(imageFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File saved successfully");
	            
	            // Lưu tên file vào entity
	            category.setImages(fileName);
	        }
	        
	        categoryService.save(category);
	        return "redirect:/admin/categories";
	    } catch (IOException e) {
	        System.err.println("Error saving file: " + e.getMessage());
	        e.printStackTrace();
	        return "redirect:/admin/categories/add?error=true";
	    }
	}

	@GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        CategoryEntity category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID:" + id));
        model.addAttribute("category", category);
        return "admin/categories/edit";  // Sửa đường dẫn
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";  // Sửa đường dẫn redirect
    }

}