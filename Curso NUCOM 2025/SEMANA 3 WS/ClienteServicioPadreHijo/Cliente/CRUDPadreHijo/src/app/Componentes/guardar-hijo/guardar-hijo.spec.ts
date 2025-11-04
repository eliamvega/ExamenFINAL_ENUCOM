import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarHijo } from './guardar-hijo';

describe('GuardarHijo', () => {
  let component: GuardarHijo;
  let fixture: ComponentFixture<GuardarHijo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarHijo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarHijo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
