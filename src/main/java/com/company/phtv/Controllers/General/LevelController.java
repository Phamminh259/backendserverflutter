package com.company.phtv.Controllers.General;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.LevelDTO;
import com.company.phtv.Services.LevelService;
import com.company.phtv.Utils.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/level")
public class LevelController {
    @Autowired
    LevelService _leveService;
    BaseController<LevelDTO> _baseController = new BaseController<LevelDTO>();
    BaseController<List<LevelDTO>> _baseControllers = new BaseController<List<LevelDTO>>();

    @GetMapping()
    public ResponseEntity<?> get() {
        try {
            return _baseControllers.success(_leveService.getAll());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return _baseController.success(_leveService.getById(id));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
