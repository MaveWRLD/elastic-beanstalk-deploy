package org.mave.simple_application;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "hello_messages")
public class HelloModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
    @NotBlank(message = "Message cannot be blank")
    @NotNull(message = "Message cannot be null")
    @Size(max = 500, message = "Message cannot exceed 500 characters")
    @Column(name = "message", nullable = false)
    private String message;
}
