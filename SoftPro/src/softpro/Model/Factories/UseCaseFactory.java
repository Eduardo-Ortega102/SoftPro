package softpro.Model.Factories;

import softpro.Model.UseCase;

public interface UseCaseFactory {

    boolean delete(UseCase useCase);

    UseCase create(int id, String description);

    UseCase create(int id, String description, String details);

}
