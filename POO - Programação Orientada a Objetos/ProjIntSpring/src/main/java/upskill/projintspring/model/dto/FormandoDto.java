package upskill.projintspring.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import upskill.projintspring.model.Formando;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormandoDto extends RepresentationModel<FormandoDto> {
    String nome;
    String email;
    long id;
    double saldo;
    String nif;

    public static FormandoDto toFormandoDto(Formando f){
        return new FormandoDto(f.getNome(),f.getEmail(),f.getId(),f.getSaldo(),f.getNif());
    }
}
