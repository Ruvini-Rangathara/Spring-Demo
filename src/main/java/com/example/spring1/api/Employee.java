package com.example.spring1.api;

import com.example.spring1.dto.EmpUpdate;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/emp")
public class Employee {

    @GetMapping(params={"id","name"})
    public String saveEmployee(String id, String name, @RequestParam MultiValueMap<String, String> empData){
        System.out.println(empData);
        return String.format("EmpDetails(%s,%s)",id, name);
    }


        @PostMapping(params={"id","name"})
        public String saveEmployee(@RequestParam MultiValueMap<String, String> empData) {
//            System.out.println(empData);

            List<String> ids = empData.get("id");
            List<String> names = empData.get("name");

            StringBuilder result = new StringBuilder();
            result.append("All empData: {");
            for (int i = 0; i < ids.size(); i++) {
                result.append("emp=[").append(ids.get(i)).append(", ").append(names.get(i)).append("]");
                if (i < ids.size() - 1) {
                    result.append(", ");
                }
            }
            result.append("}");

            System.out.println(result);
            return result.toString();
        }

        @PutMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, params = {"towns"})
        public String getMultiTypeData(
                String id, String country, String city,
                @RequestParam String[] towns,
                @RequestParam Map<String, String> data
        ){

        printValues(id,city,country,towns);
            System.out.println(data);
            return "Saved";

        }

    private void printValues(String id, String city, String country, String[] towns) {
        System.out.println("Id : "+id);
        System.out.println("City : "+city);
        System.out.println("Country : "+country);
        System.out.println("Towns : "+ Arrays.toString(towns));
    }


    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String JsonDataExtractOne(@RequestBody EmpUpdate emp){
        System.out.println(emp.getId());
        System.out.println(emp.getName());

        return "Updated";
    }

}
