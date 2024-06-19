package net.javaguides.employeeservice.service.impl;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.EmailAlreadyExistsException;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /*
    @Autowired
    private RestTemplate restTemplate;
     */
    /*
    @Autowired
    private WebClient webClient;
     */
    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employeeDto.getEmail());
        if (employeeOptional.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee employeeSaved= employeeRepository.save(employee);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employeeSaved);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        /*
        ResponseEntity<DepartmentDto> responseEntity  = restTemplate.getForEntity("http://localhost:8080/api/departments/"
                        + employee.getDepartamentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
         */

        /*
        DepartmentDto departmentDto = webClient.get().
                uri("http://localhost:8080/api/departments/"+ employee.getDepartamentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        */
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartamentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();

        apiResponseDto.setEmployeeDto(AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee));
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
