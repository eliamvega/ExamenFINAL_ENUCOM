import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarHijo } from './listar-hijo';

describe('ListarHijo', () => {
  let component: ListarHijo;
  let fixture: ComponentFixture<ListarHijo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarHijo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarHijo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
