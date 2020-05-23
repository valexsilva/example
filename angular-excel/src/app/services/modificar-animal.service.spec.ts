import { TestBed } from '@angular/core/testing';

import { ModificarAnimalService } from './modificar-animal.service';

describe('ModificarAnimalService', () => {
  let service: ModificarAnimalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModificarAnimalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
