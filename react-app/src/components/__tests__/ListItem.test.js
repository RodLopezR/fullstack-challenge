import React from 'react';
import ListItem from '../list/ListItem.Component';

describe('ListItem Component', function() {

    it("renders correctly with shallow", () => {
        const wrapper = shallow(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);  
        expect(wrapper).toMatchSnapshot();
    });

    it("renders correctly with render", () => {
        const wrapper = render(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);  
        expect(wrapper).toMatchSnapshot();
    });

    it("renders correctly with mount", () => {
        const wrapper = mount(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);  
        expect(wrapper).toMatchSnapshot();
    });  
    
    /*it('should be selectable by selector "tr"', function() {
        const wrapper = mount(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);
        expect(wrapper.is('div')).toBe(true);
    });*/

    it("formats temp correctly", () => {
        const wrapper = mount(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);
        const text = wrapper.find("span").text();
        expect(text).toEqual("(1)");
    });  
  
    it('should render to static HTML', function() {
        const wrapper = render(<ListItem item={{ evaluacion: 1 }} onEdit={null} onRemove={null}/>);
        expect(wrapper.text()).not.toBeNull();
    });
});