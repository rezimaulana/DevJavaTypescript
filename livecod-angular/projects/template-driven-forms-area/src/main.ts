import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { TemplateDrivenFormsAreaModule } from './app/template-driven-forms-area.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(TemplateDrivenFormsAreaModule)
  .catch(err => console.error(err));
