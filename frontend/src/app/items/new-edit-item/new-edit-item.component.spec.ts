import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewEditItemComponent } from './new-edit-item.component';

describe('NewEditItemComponent', () => {
  let component: NewEditItemComponent;
  let fixture: ComponentFixture<NewEditItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewEditItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewEditItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
