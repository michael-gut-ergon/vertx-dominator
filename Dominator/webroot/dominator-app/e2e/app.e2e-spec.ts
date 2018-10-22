import { DominatorAppPage } from './app.po';

describe('dominator-app App', function() {
  let page: DominatorAppPage;

  beforeEach(() => {
    page = new DominatorAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
