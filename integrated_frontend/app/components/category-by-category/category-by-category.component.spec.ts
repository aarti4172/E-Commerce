import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryByCategoryComponent } from './category-by-category.component';

describe('CategoryByCategoryComponent', () => {
  let component: CategoryByCategoryComponent;
  let fixture: ComponentFixture<CategoryByCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryByCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
