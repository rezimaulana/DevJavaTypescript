import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { ReactiveFormsAreaModule } from './app/reactive-forms-area.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(ReactiveFormsAreaModule)
  .catch(err => console.error(err));
