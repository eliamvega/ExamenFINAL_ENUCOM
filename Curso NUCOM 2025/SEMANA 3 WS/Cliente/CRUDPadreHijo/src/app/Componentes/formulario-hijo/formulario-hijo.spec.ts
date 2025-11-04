import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioHijo } from './formulario-hijo';

describe('FormularioHijo', () => {
  let component: FormularioHijo;
  let fixture: ComponentFixture<FormularioHijo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioHijo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioHijo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
