import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarVeterinaria } from './listar-veterinaria';

describe('ListarVeterinaria', () => {
  let component: ListarVeterinaria;
  let fixture: ComponentFixture<ListarVeterinaria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarVeterinaria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarVeterinaria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
